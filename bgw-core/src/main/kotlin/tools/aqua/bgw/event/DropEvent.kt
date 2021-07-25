/*
 *    Copyright 2021 The BoardGameWork Authors
 *    SPDX-License-Identifier: Apache-2.0
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package tools.aqua.bgw.event

import tools.aqua.bgw.elements.ElementView

/**
 * Event that gets raised for drop gestures.
 * Receiver is the dragged element.
 *
 * @param draggedElement currently dragged [ElementView].
 * @param dragTargets list of all [ElementView]s that accepted the drag gesture in case of a dragGestureEnded [Event].
 * Contains all accepting [ElementView]s in the order they accepted.
 *
 * @see DragEvent
 */
class DropEvent(val draggedElement: ElementView, val dragTargets: List<ElementView> = listOf()) : Event()